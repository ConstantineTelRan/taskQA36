package util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> newContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"John", "john@gmail.com", "JohnAddress1", "JohnAddress1"});
        list.add(new Object[]{"Michael", "michael@gmail.com", "MichaelAddress1", "MichaelAddress2"});
        list.add(new Object[]{"Kate", "kata@gmail.com", "KateAddress1", "KateAddress2"});
        return list.listIterator();
    }


    @DataProvider
    public Iterator<Object[]> newContactWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{split[0], split[1], split[2], split[3]});
            line = reader.readLine();
        }
        return list.listIterator();
    }
}
