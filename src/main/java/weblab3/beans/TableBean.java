package weblab3.beans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("table")
@SessionScoped
public class TableBean implements Serializable {
    private final List<RowBean> table;

    public TableBean() {
        table = new ArrayList<>();
        System.out.println("SLAVA GAY FROM TABLE BEAN");
    }

    public List<RowBean> getTable() {
        return table;
    }

    public void addToTable(RowBean row) {
        table.add(row);
    }
}