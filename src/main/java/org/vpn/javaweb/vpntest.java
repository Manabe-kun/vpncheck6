/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vpn.javaweb;
import java.io.IOException;
import vpn.detection.*; 
/**
 *
 * @author karas
 */
public class vpntest {
   
  public  vpntest()
   {
       
   }
  public void GetIp(){
       VPNDetection vpn_detection = new VPNDetection();
new Thread(() -> {
    try {
        
        String ipToLookup = "123.201.105.46";
        Response api_response = vpn_detection.getResponse(ipToLookup);
        
        if(api_response.status.equals("success")) {
            System.out.println("Package: " + api_response.getPackage);
            if(api_response.getPackage.equals("Free")) {
                System.out.println("Remaining Requests: " + api_response.remaining_requests);
            }
            System.out.println("IP Address: " + api_response.ipaddress);
            System.out.println("Is this IP a VPN or Hosting Network? " + api_response.hostip);
            System.out.println("Organisation: " + api_response.org);
            if(api_response.country != null) {
                System.out.println("Country: " + api_response.country.name);
            }
            
        } else {
            System.out.println("Error: " + api_response.msg);
        }
//IOException
    } catch (IOException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
       }).start();
  }
}
