package Order;

import Shipping.Address;
import Item.*;
import java.util.Scanner;
import java.util.Arrays;

public class Order
{
    private int id;
    private double price;
    private String date;
    private int earnedPoints;
    //private paymentMethod paymentMethod;
    private Address address;
    //private Item items[];
    protected static int CounterId=0;
    //private OrderStatus orderStatus;
    public String phoneNumber;

    public Order(double price)
    {

        this.price = price;
        this.id=CounterId;
        CounterId++;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Government Name : ");

        String government = myObj.nextLine();  // Read user input
        System.out.println("Enter dis  : ");
        String dis = myObj.nextLine();
        System.out.println("Enter Street Name : ");
        String street = myObj.nextLine();
        System.out.println("Enter fno Number : ");
        int fno = myObj.nextInt();
        System.out.println("Enter lmark Name : ");
        myObj.nextLine();
        String lmark = myObj.nextLine();
        address = new Address(government,dis,street,fno,lmark);
        System.out.println("your order confirmed successfully !");
    }

    //public paymentMethod getPaymentMethod() {
    //return paymentMethod;
    //}

    //public void setPaymentMethod(paymentMethod paymentMethod) {
    //   this.paymentMethod = paymentMethod;
    //}
    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public int getEarnedPoints() {
        return earnedPoints;
    }





    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEarnedPoints(int earnedPoints) {
        this.earnedPoints = earnedPoints;
    }







    // public OrderStatus getOrderStatus() {
    //    return orderStatus;
    //}

    //public void setOrderStatus(OrderStatus orderStatus) {
    //    this.orderStatus = orderStatus;
    //}
/*
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", earnedPoints=" + earnedPoints +
                ", paymentMethod=" + paymentMethod +
                ", address=" + address +
                ", items=" + Arrays.toString(items) +
                ", orderStatus=" + orderStatus +
                '}';
    }
     */
}

