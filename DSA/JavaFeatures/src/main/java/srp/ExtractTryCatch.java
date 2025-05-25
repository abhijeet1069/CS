package srp;

// Error handling is one thing
public class ExtractTryCatch {

    public static int strLength(String str){
        int res = 0;
        try{
            res = str.length();
        }
        catch(Exception e){
            LoggerUtil.logError(e);
        }
        LoggerUtil.logInfo(String.format("input: \"%s\" length: %d", str, res));
        return res;
    }

    public static void main(String[] args) {
        LoggerUtil.logInfo("start");
        String msg = "Fe Fi Fo Fum I smell the blood of a little boy Fe Fi Fo Fum";
        strLength(msg);
        String msg1 = null;
        strLength(msg1);
    }
}
