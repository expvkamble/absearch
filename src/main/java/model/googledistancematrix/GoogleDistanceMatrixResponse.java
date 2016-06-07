package model.googledistancematrix;

import java.util.ArrayList;

/**
 * Created by vkamble on 6/7/16.
 */
public class GoogleDistanceMatrixResponse {

    ArrayList<Row> rows;

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }
}
