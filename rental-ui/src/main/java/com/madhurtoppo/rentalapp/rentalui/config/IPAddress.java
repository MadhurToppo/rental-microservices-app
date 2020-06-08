package com.madhurtoppo.rentalapp.rentalui.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {

  public static void getIPAddress() {
    InetAddress ip;
    try {
      ip = InetAddress.getLocalHost();
      System.out.println("Your IP Address is: "+ ip);
      System.out.println("Your Host Address is: "+ ip.getHostAddress());
      System.out.println("Your Hostname is: "+ ip.getHostName());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

}
