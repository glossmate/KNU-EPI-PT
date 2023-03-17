package KNU;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UTIL {

    static int LOG_LEVEL = 5;

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public static String getCurrentTimeStamp_EXT_MILI_SEC() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    private static String STR_DEFAULT_LOG_DIRECTORY = "LOG_DIR";
    public static void LOG(int arg_LOG_LEVEL, String STR_TAG, String STR_LOG) {

        if (LOG_LEVEL < arg_LOG_LEVEL) return;

        try {
            Date LOG_DATE = new Date();

            String STR_LOG_FILE_PATH = "";
            if (STR_LOG.startsWith("/")) {
                STR_LOG_FILE_PATH =
                        String.format(
                                "%s/%s/%s",
                                STR_DEFAULT_LOG_DIRECTORY,
                                (new SimpleDateFormat("yyyy/MM")).format(LOG_DATE),
                                "LOG_" + (new SimpleDateFormat("yyyyMMdd")).format(LOG_DATE) + ".LOG"
                        );

            } else {
                String str_ABSPATH_For_Class =
                        new File(UTIL.class.getProtectionDomain()
                                .getCodeSource()
                                .getLocation()
                                .toURI()
                                .getPath())
                                .getParent()
                                .toString();

                STR_LOG_FILE_PATH =
                        String.format(
                                "%s/%s/%s/%s",
                                str_ABSPATH_For_Class,
                                STR_DEFAULT_LOG_DIRECTORY,
                                (new SimpleDateFormat("yyyy/MM")).format(LOG_DATE),
                                "LOG_" + (new SimpleDateFormat("yyyyMMdd")).format(LOG_DATE) + ".LOG"
                        );
            }

            File logFile = new File(STR_LOG_FILE_PATH);
            if(!logFile.exists()) {
                logFile.getParentFile().mkdirs();
                logFile.createNewFile();
            }

            UTIL.LOG(STR_LOG_FILE_PATH, STR_TAG, STR_LOG);
        } catch (Exception e) {
            UTIL.LOG(0, STR_TAG, String.format("UTIL : %s", e));
        }

    }

    public static void LOG(String STR_LOG_FILE, String STR_TAG, String STR_LOG) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            String STR_CurrentTimeStamp = getCurrentTimeStamp_EXT_MILI_SEC();
            fw = new FileWriter(STR_LOG_FILE, true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);

            String LOG_LINE =  String.format(
                    "%s - %s : %s",
                    STR_CurrentTimeStamp,
                    STR_TAG,
                    STR_LOG
            );

            out.println(LOG_LINE);
            out.close();
            System.out.println(LOG_LINE);
        } catch (IOException e) {
            System.out.println(String.format("%s", e));
        }
        finally {
            try {
                if(out != null) out.close();
                if(bw != null) bw.close();
                if(fw != null) fw.close();
            } catch (IOException e) {
                System.out.println(String.format("%s", e.toString()));
            }
        }
    }
}
