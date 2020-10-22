package com.laurelautolease.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.laurelautolease.laurelAutoLease.Lal;
import com.laurelautolease.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;


@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;


    @Autowired
    public CommandLineAppStartupRunner(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        try {
            DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
           /* deleteTable();
            createTable(amazonDynamoDB, dynamoDBMapper);*/
            listMyTables(dynamoDB);
            getTableInfor(dynamoDB);

        } catch (Exception e) {

        }
    }


    static void createTable(AmazonDynamoDB amazonDynamoDB, DynamoDBMapper dynamoDBMapper) {
        try {
            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(Vehicle.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));
            amazonDynamoDB.createTable(tableRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(Lal.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));
            amazonDynamoDB.createTable(tableRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void listMyTables(DynamoDB dynamoDB) {
        try {
            TableCollection<ListTablesResult> tables = dynamoDB.listTables();
            Iterator<Table> iterator = tables.iterator();

            System.out.println("Listing table names");

            while (iterator.hasNext()) {
                Table table = iterator.next();
                System.out.println(table.getTableName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTable() {

        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);

        Table table = dynamoDB.getTable("Lal");
        Table table2 = dynamoDB.getTable("Vehicle");
        try {
            System.out.println("Attempting to delete table; please wait...");
            table.delete();
            table.waitForDelete();
            System.out.print("Success.");

        } catch (Exception e) {
            System.err.println("Unable to delete table: ");
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Attempting to delete table; please wait...");
            table2.delete();
            table2.waitForDelete();
            System.out.print("Success.");

        } catch (Exception e) {
            System.err.println("Unable to delete table: ");
            System.err.println(e.getMessage());
        }
    }

    public void getTableInfor(DynamoDB dynamoDB) {

        System.out.println("Describing " + "Vehicle");

        TableDescription tableDescription = dynamoDB.getTable("Vehicle").describe();
        System.out.format(
                "Name: %s:\n" + "Status: %s \n" + "Provisioned Throughput (read capacity units/sec): %d \n"
                        + "Provisioned Throughput (write capacity units/sec): %d \n",
                tableDescription.getTableName(), tableDescription.getTableStatus(),
                tableDescription.getProvisionedThroughput().getReadCapacityUnits(),
                tableDescription.getProvisionedThroughput().getWriteCapacityUnits());

    }

}
