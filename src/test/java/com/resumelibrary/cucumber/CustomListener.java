package com.resumelibrary.cucumber;

import com.resumelibrary.utilities.*;
import org.testng.*;

import java.io.*;

import com.lambdatest.tunnel.Tunnel;

import java.util.List;
import java.util.Map;

public class CustomListener extends Utility implements ITestListener, IExecutionListener {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomListener.class);


    @Override
    public void onExecutionStart() {
        /*tunnelObject=new ArrayList<Tunnel>();
        boolean flag=false;
        String username = PropertyFileReader.getInstance().getProperty("lambdaUsername");
        String accessKey = PropertyFileReader.getInstance().getProperty("lambdaAccessKey");
        HashMap<String, String> options1 = new HashMap<String, String>();
        options1.put("user", username);
        options1.put("key", accessKey);
        options1.put("load-balanced","true");
        options1.put("tunnelName", "RLRegressionTunnel");
        int i=0;
        do{
            flag= startTunnel(options1);
            i++;
        }while(!flag && i<2);

        HashMap<String, String> options2 = new HashMap<String, String>();
        options2.put("user", username);
        options2.put("key", accessKey);
        options2.put("load-balanced","true");
        options2.put("tunnelName", "RLRegressionTunnel");
        i=0;
        do{
            flag= startTunnel(options2);
            i++;
        }while(!flag && i<2);
        HashMap<String, String> options3 = new HashMap<String, String>();
        options3.put("user", username);
        options3.put("key", accessKey);
        options3.put("load-balanced","true");
        options3.put("tunnelName", "RLRegressionTunnel");
        i=0;
        do{
            flag= startTunnel(options3);
            i++;
        }while(!flag && i<2);
        HashMap<String, String> options4 = new HashMap<String, String>();
        options4.put("user", username);
        options4.put("key", accessKey);
        options4.put("load-balanced","true");
        options4.put("tunnelName", "RLRegressionTunnel");
        i=0;
        do{
            flag= startTunnel(options4);
            i++;
        }while(!flag && i<2);
        HashMap<String, String> options5 = new HashMap<String, String>();
        options5.put("user", username);
        options5.put("key", accessKey);
        options5.put("load-balanced","true");
        options5.put("tunnelName", "RLRegressionTunnel");

        i=0;
        do{
            flag= startTunnel(options5);
            i++;
        }while(!flag && i<2);
        HashMap<String, String> options6 = new HashMap<String, String>();
        options6.put("user", username);
        options6.put("key", accessKey);
        options6.put("load-balanced","true");
        options6.put("tunnelName", "RLRegressionTunnel");
        i=0;
        do{

            flag= startTunnel(options6);
            i++;
        }while(!flag && i<2);
        HashMap<String, String> options7 = new HashMap<String, String>();
        options7.put("user", username);
        options7.put("key", accessKey);
        options7.put("load-balanced","true");
        options7.put("tunnelName", "RLRegressionTunnel");
        i=0;
        do{

            flag= startTunnel(options7);
            i++;
        }while(!flag && i<2);
        HashMap<String, String> options8 = new HashMap<String, String>();
        options8.put("user", username);
        options8.put("key", accessKey);
        options8.put("load-balanced","true");
        options8.put("tunnelName", "RLRegressionTunnel");
        i=0;
        do{

            flag= startTunnel(options8);
            i++;
        }while(!flag && i<2);
        HashMap<String, String> options9 = new HashMap<String, String>();
        options9.put("user", username);
        options9.put("key", accessKey);
        options9.put("load-balanced","true");
        options9.put("tunnelName", "RLRegressionTunnel");
        i=0;
        do{

            flag= startTunnel(options9);
            i++;
        }while(!flag && i<2);*/
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        try {
            artGen.printText("RL Regression started");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.createFailedExcel();
    }

    @Override
    public void onExecutionFinish() {
       /* try {
            for(int i=0;i<tunnelObject.size();i++){
                    tunnelObject.get(i).stopTunnel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        try {
            artGen.printText("RL Regression Finished");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext arg0) {

   }
    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
   }

 @Override
    public void onTestSkipped(ITestResult arg0) {
     }

    @Override
    public void onTestStart(ITestResult arg0) {
   }

    @Override
    public void onTestSuccess(ITestResult arg0) {
    }

    public synchronized boolean startTunnel(Map options) {
        boolean flag = false;
        /*try{
            for(int i = 0; i < 5; ++i) {
                Thread.sleep(1000L);
            }
            Tunnel t=new Tunnel();
                flag = t.start(options);
            if(flag) {
                tunnelObject.add(t);
            }
        }catch (Exception e){
            flag=false;

        }*/
        return flag;
    }
}