//package pl.put.poznan.jtools.logic;
//import org.junit.jupiter.api.Test;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
////class JsonBlacklistTest {
////    @Test
////    public void testblacklisting(){
////        String jsonInString = "{\"jsonText\": {\"this\": \n[\"is\",5,4], \"an\": {\"nested\": \"thing\", \"or\": \"something\"},\n         \"to\": \"beautify\", \"number\": 5}"
////        List<String> blacklist = new ArrayList<String>("this","an","nested");
////        String blacklisted = JsonBlacklist.recursiveBlacklistFilter(jsonInString, blacklist);
////        System.out.println(blacklisted);
////    }
////}