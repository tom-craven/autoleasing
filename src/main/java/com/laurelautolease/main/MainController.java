package com.laurelautolease.main;

import com.laurelautolease.config.EmailServiceImpl;
import com.laurelautolease.laurelAutoLease.Lal;
import com.laurelautolease.laurelAutoLease.LalRepository;
import com.laurelautolease.vehicle.Vehicle;
import com.laurelautolease.vehicle.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    private final VehicleRepository vehicleRepository;
    private final LalRepository lalRepository;

    @Value("${google.recaptcha.key.secret}")
    private String recaptureSecret;

    @Value("${aws.s3.vehicle.bucket}")
    private String s3VehicleImageBucket;

    @Value("${aws.s3.bucket}")
    private String s3ImageBucket;
    private EmailServiceImpl emailService;

    @Value("${spring.mail.username}")
    private String mailAddress;


    @Autowired
    public MainController(LalRepository lalRepository, VehicleRepository vehicleRepository, EmailServiceImpl emailService) {
        this.lalRepository=lalRepository;
        this.vehicleRepository = vehicleRepository;
        this.emailService = emailService;
    }


    @GetMapping("/")
    public String index() {
        return "forward:main";
    }

    @GetMapping("/main")
    public String list(Model model) {
        model.addAttribute("vueModel",
                lalRepository.findById("0").isPresent()?
                        lalRepository.findById("0").get():new Lal());
        model.addAttribute("s3VehicleImageBucket",s3VehicleImageBucket);
        model.addAttribute("s3ImageBucket",s3ImageBucket);
        Iterable<Vehicle> vehiclelist=vehicleRepository.findAll();
        if (vehiclelist.iterator().hasNext()){
            model.addAttribute("vehicles", vehiclelist);
        }
        return "main";
    }

    @GetMapping("/quote")
    public String form(Model model, QuoteForm quoteForm) {
        model.addAttribute("quoteForm", quoteForm);
        model.addAttribute("vehicle", new Vehicle(true));
        model.addAttribute("s3VehicleImageBucket",s3VehicleImageBucket);
        model.addAttribute("s3ImageBucket",s3ImageBucket);
        return "quote";
    }

    @PostMapping(value = "/quote")
    public String postQuote(@ModelAttribute QuoteForm quoteForm) {
        log.info(quoteForm.toString());
        emailQuote(quoteForm.toString());
        return "redirect:/";
    }

    @GetMapping("/callback")
    public String callBack(Model model, CallbackForm callbackForm, Vehicle vehicle) {
        model.addAttribute("callbackForm", callbackForm);
        model.addAttribute("vehicle", vehicle);
        return "callback";
    }

    @PostMapping(value = "/callback")
    public String postFinal(@ModelAttribute CallbackForm callbackForm) {
        log.info(callbackForm.toString());
        emailCallback(callbackForm.toString());
        return "redirect:/";
    }

    private void emailCallback(String text) {
        try{
            emailService.sendSimpleMessage(mailAddress, "Callback Request Received", text);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void emailQuote(String text) {
        try{
            emailService.sendSimpleMessage(mailAddress, "Quote Request Received", text);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
