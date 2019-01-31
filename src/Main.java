import com.sun.deploy.util.StringUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CSVFilter filter = new CSVFilter();
        filter.filterNamesByMonth("./resources/input.csv", "May", "./resources/output.csv") ;

    }
}
