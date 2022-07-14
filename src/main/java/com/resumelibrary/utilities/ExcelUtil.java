package com.resumelibrary.utilities;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Iterator;

public class ExcelUtil {
    private static final Logger logger = LogManager.getLogger(ExcelUtil.class);

    public synchronized void createFailedExcel() {
        logger.info("[--->in createFailedExcel<----]");
        String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("browserStackBuildId");
        String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
        try {
            String filename = "FailedScenarios_" + buildId + ".xlsx";
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("RLRegression");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("S.No");
            rowhead.createCell(1).setCellValue("Build No");
            rowhead.createCell(2).setCellValue("Vertical");
            rowhead.createCell(3).setCellValue("Scenario");
            rowhead.createCell(4).setCellValue("Tags");
            rowhead.createCell(5).setCellValue("Failed Step");
            rowhead.createCell(6).setCellValue("Skip Test");
            rowhead.createCell(7).setCellValue("Failed Reason");
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            logger.info("[--->Created excel file successfully for the build:" + buildId+"<----]");
        } catch (Exception e) {
            logger.info("[--->Failed to Created excel file for the build:" + buildId+"<----]");
            e.printStackTrace();
        }
    }

    public synchronized void addRowsFailedExcel(FailedScenarioPojo failedScenario,String skipTest) {
        logger.info("[--->in addRowsFailedExcel<---]");
        try {
            if(!checkScenarioExist(failedScenario.getTagDetails())) {
                String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("browserStackBuildId");
                String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
                FileInputStream myxls = new FileInputStream("FailedScenarios_" + buildId + ".xlsx");
                HSSFWorkbook studentsSheet = new HSSFWorkbook(myxls);
                HSSFSheet worksheet = studentsSheet.getSheetAt(0);
                int lastRow = worksheet.getLastRowNum();
                Row row = worksheet.createRow(++lastRow);
                row.createCell(0).setCellValue(lastRow);
                row.createCell(1).setCellValue(buildId);
                row.createCell(2).setCellValue(getVerticalName(failedScenario.getTagDetails()));
                row.createCell(3).setCellValue(failedScenario.getScenarioName());
                row.createCell(4).setCellValue(failedScenario.getTagDetails());
                row.createCell(5).setCellValue(failedScenario.getStepDescription());
                row.createCell(6).setCellValue(skipTest);
                row.createCell(7).setCellValue(failedScenario.getFailedReason());
                myxls.close();
                FileOutputStream output_file = new FileOutputStream("FailedScenarios_" + buildId + ".xlsx");
                studentsSheet.write(output_file);
                output_file.close();
                logger.info("[--->written into excel file successfully for the failed scenario:" + failedScenario.getScenarioName()+"<-----]");
            }
        } catch (Exception e) {
            logger.info("[--->failed to write into excel file for the failed scenario:" + failedScenario.getScenarioName()+"<-------]");
            e.printStackTrace();
        }
    }
    public synchronized void addRowsFailedExcelWithRetry(FailedScenarioPojo failedScenario) {
        logger.info("[--->in addRowsFailedExcelWithRetry<----]");
          try {
                String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("browserStackBuildId");
                String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
                FileInputStream myxls = new FileInputStream("FailedScenarios_" + buildId + ".xlsx");
                HSSFWorkbook studentsSheet = new HSSFWorkbook(myxls);
                HSSFSheet worksheet = studentsSheet.getSheetAt(0);
                int lastRow = worksheet.getLastRowNum();
                Row row = worksheet.createRow(++lastRow);
                row.createCell(0).setCellValue(lastRow);
                row.createCell(1).setCellValue(buildId);
                row.createCell(2).setCellValue(getVerticalName(failedScenario.getTagDetails()));
                row.createCell(3).setCellValue(failedScenario.getScenarioName());
                row.createCell(4).setCellValue(failedScenario.getTagDetails());
                row.createCell(5).setCellValue(failedScenario.getStepDescription());
                row.createCell(6).setCellValue(failedScenario.getFailedReason());
                row.createCell(7).setCellValue(failedScenario.getFailedReason());
                myxls.close();
                FileOutputStream output_file = new FileOutputStream("FailedScenarios_" + buildId + ".xlsx");
                studentsSheet.write(output_file);
                output_file.close();
                logger.info(" --->written into excel file successfully for the failed scenario:" + failedScenario.getScenarioName());
        } catch (Exception e) {
            logger.info("--->failed to write into excel file for the failed scenario:" + failedScenario.getScenarioName());
            e.printStackTrace();
        }
    }

    public boolean checkScenarioExist(String scenarioName) throws IOException {
        logger.info("[--->in checkScenarioExist<----]");
        boolean existScenario = false;
        String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("browserStackBuildId");
        String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
        FileInputStream myxls = new FileInputStream("FailedScenarios_" + buildId + ".xlsx");
        HSSFWorkbook studentsSheet = new HSSFWorkbook(myxls);
        HSSFSheet worksheet = studentsSheet.getSheetAt(0);
       Iterator<Row> rows = worksheet.rowIterator();
        while (rows.hasNext()) {
            HSSFRow row = (HSSFRow) rows.next();
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                HSSFCell cell = (HSSFCell) cells.next();
                if (cell.toString().equalsIgnoreCase(scenarioName)) {
                    existScenario = true;
                    break;
                }
           }
        }
        return existScenario;
    }

    public synchronized void removePassedScenario(String scenarioName) {
        logger.info("[--->in removePassedScenario<----]");
        try {
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("browserStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            FileInputStream myxls = new FileInputStream("FailedScenarios_" + buildId + ".xlsx");
            HSSFWorkbook studentsSheet = new HSSFWorkbook(myxls);
            HSSFSheet worksheet = studentsSheet.getSheetAt(0);
            Iterator<Row> rows = worksheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    if (cell.getStringCellValue().contains(scenarioName)) {
                        worksheet.removeRow(row);
                        break;
                    }

                }
            }
        }catch (Exception e){
            logger.info("[--->failed to remove from excel file for the passed scenario:" + scenarioName+"<---]");
            e.printStackTrace();
        }
    }
public String getVerticalName(String tags){
    logger.info("[--->in getVerticalName<---]");
        if(tags.contains("@Recruiters")){
            return "Recruiters";
        }else if(tags.contains("@Partnerships")){
            return "Partnerships";
        }else if(tags.contains("@Traffic")) {
            return "Traffic";
        }else if(tags.contains("@Candidate")) {
            return "Candidate";
        }else if(tags.contains("@Search")) {
            return "Search";
        }else{
            return "Not matching with any vertical";
        }
}
}