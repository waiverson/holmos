package Holmos.dbtest.database.datasetloadstrategy;

import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;

import Holmos.dbtest.database.connecion.HolmosDataBaseConnection;
import Holmos.webtest.exceptions.HolmosFailedError;
/**将数据库中和DataSet中有的记录进行更新,数据库中没有的进行插入
 * @author 吴银龙(15857164387)
 * */
public class HolmosRefreshLoadStrategy implements HolmosDataSetLoadStrategy{

	public void excute(HolmosDataBaseConnection conn, IDataSet dataset) {
		try {
			DatabaseOperation.REFRESH.execute(conn, dataset);
		} catch (DatabaseUnitException e) {
			throw new HolmosFailedError("CLEAN_INSERT执行异常");
		} catch (SQLException e) {
			throw new HolmosFailedError("CLEAN_INSERT执行异常");
		}
	}

}
