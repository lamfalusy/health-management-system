package hu.lamsoft.hms.androidclient.component.session;

import java.util.List;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.customer.async.HistoricalDataAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerHistoricalDataDTO;
import hu.lamsoft.hms.androidclient.restapi.regimen.enums.Meal;
import hu.lamsoft.hms.androidclient.restapi.unit.async.UnitAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.unit.dto.UnitDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class CustomerData {

    private List<UnitDTO> units;
    private List<CustomerHistoricalDataDTO> historicalDatas;

    public void build() {
        new UnitAsyncTask(new AsyncCallback<List<UnitDTO>>() {
            @Override
            public void onPostExecute(List<UnitDTO> unitDTOs) {
                units = unitDTOs;
            }
        }).execute();
        new HistoricalDataAsyncTask(new AsyncCallback<List<CustomerHistoricalDataDTO>>() {
            @Override
            public void onPostExecute(List<CustomerHistoricalDataDTO> customerHistoricalDataDTOs) {
                historicalDatas = customerHistoricalDataDTOs;
            }
        }).execute();
    }

    public List<UnitDTO> getUnits() {
        return units;
    }

    public List<CustomerHistoricalDataDTO> getHistoricalDatas() {
        return historicalDatas;
    }
}
