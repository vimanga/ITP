package com.example.demo.dao.SalesManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.example.demo.model.SalesManagement.InstallationCertificate;

@Service
public class InstallationCertificateDAO {
	JdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	// Add to Installation Certificate table
	public void save(InstallationCertificate i,String orID) {
		
		
		//String sql = "SET @ORDID= (SELECT orID FROM sales WHERE )";
		String sql2 ="SET @CLIENTID= (SELECT custID FROM client_order WHERE client_order_code='"+orID+"')";
		
		String sql3 ="SET @TECHID= (SELECT techID FROM sales WHERE orID='"+orID+"')";
		String sql4 ="SET @DRIVERID= (SELECT driverID FROM sales WHERE orID='"+orID+"')";
		
		String sql5 = "insert into installation_certificate(ordId,clienId,techId,drivId,cableLen,conduitLen,timeIn,timeOut,dateInstalled,\r\n"
				+ "swInstalled,swInstalledDescription,opTraining,opTrainingDescription,fullyOperational,fullyOperationalDescription) values('"+orID+"',@CLIENTID,@TECHID,@DRIVERID,"
				+ i.getCableLen() + "," + i.getConduitLen() + ",'" + i.getTimeIn() + "','" + i.getTimeOut() + "','"
				+ i.getDateInstalled() + "','" + i.getSwInstalled() + "','" + i.getSwInstalledDescription() + "','"
				+ i.getOpTraining() + "','" + i.getOpTrainingDescription() + "','" + i.getFullyOperational() + "','"
				+ i.getFullyOperationalDescription() + "')";

		String sql6 = "update installation_certificate SET installationCode = concat(installationPrefix,installationID)";

		//System.out.println("IC SQL1"+sql);
		System.out.println("IC SQL2"+sql2);
		System.out.println("IC SQL3"+sql3);
		System.out.println("IC SQL4"+sql4);
		System.out.println("IC SQL5"+sql5);
		System.out.println("IC SQL6"+sql6);
		template.batchUpdate(sql2, sql3,sql4,sql5,sql6);
	}

	// Add Items
	public void saveItem(InstallationCertificate i, String code) {
		//int num = i.getNumOfDev();

		System.out.println("Number of devices" + i.getNumOfDev());
		System.out.println("Code ::" + code);
		String sql = "SET @var = (select installationID from installation_certificate where installationCode = '" + code
				+ "')";
		String sql3 = "insert into installation_device (instID,devicesCode,quantity)values (@var,'" + i.getDevicesCode()
				+ "'," + i.getQuantity() + ")";

		System.out.println(sql);
		System.out.println(sql3);

		template.batchUpdate(sql, sql3);
	}

	// ----------------------------------------------------------------------------------------

	// Retrieve All Added Items by id
	public List<InstallationCertificate> getAddItemsByID(int id) {
		String sql1 = "select * from installation_device where instID = " + id +";" ;
		return template.query(sql1, new ResultSetExtractor<List<InstallationCertificate>>() {
			public List<InstallationCertificate> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<InstallationCertificate> list = new ArrayList<InstallationCertificate>();
				
				while (rs.next()) {
					InstallationCertificate e = new InstallationCertificate();
					e.setInstID(rs.getInt(1));
					e.setDevicesCode(rs.getString(2));
					e.setQuantity(rs.getInt(3));
				
					list.add(e);
				}
				return list;
			}

		});

	}

	// Retrieve All Installation Certificates

	public List<InstallationCertificate> getAllInstallationCertificates() {

		return template.query("select * from installation_certificate",
				new ResultSetExtractor<List<InstallationCertificate>>() {
					public List<InstallationCertificate> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<InstallationCertificate> list = new ArrayList<InstallationCertificate>();

						while (rs.next()) {

							InstallationCertificate e = new InstallationCertificate();
							e.setInstallationID(rs.getInt(1));
							e.setInstallationCode(rs.getString(3));
							e.setOrdId(rs.getString(4));
							e.setClienId(rs.getString(5));
							e.setTechId(rs.getString(6));
							e.setDrivId(rs.getString(7));
							e.setCableLen(rs.getDouble(8));
							e.setConduitLen(rs.getDouble(9));
							e.setSwInstalled(rs.getString(10));
							e.setSwInstalledDescription(rs.getString(11));
							e.setOpTraining(rs.getString(12));
							e.setOpTrainingDescription(rs.getString(13));
							e.setFullyOperational(rs.getString(14));
							e.setFullyOperationalDescription(rs.getString(15));
							e.setTimeIn(rs.getString(16));
							e.setTimeOut(rs.getString(17));
							e.setDateInstalled(rs.getString(18));

							list.add(e);
						}
						return list;
					}

				});

	}

	// Retrieve All Installation Certificates by page

	public List<InstallationCertificate> getAllInstallationCertificatesByPage(int pageid, int total) {
		String sql = "select * from installation_certificate limit 3" + (pageid - 1) + "," + total;

		return template.query(sql, new ResultSetExtractor<List<InstallationCertificate>>() {
			public List<InstallationCertificate> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<InstallationCertificate> list = new ArrayList<InstallationCertificate>();

				while (rs.next()) {

					InstallationCertificate e = new InstallationCertificate();
					e.setInstallationID(rs.getInt(1));
					e.setOrdId(rs.getString(2));
					e.setClienId(rs.getString(3));
					e.setTechId(rs.getString(4));
					e.setDrivId(rs.getString(5));
					e.setCableLen(rs.getDouble(6));
					e.setConduitLen(rs.getDouble(7));
					e.setSwInstalled(rs.getString(8));
					e.setSwInstalledDescription(rs.getString(9));
					e.setOpTraining(rs.getString(10));
					e.setOpTrainingDescription(rs.getString(11));
					e.setFullyOperational(rs.getString(12));
					e.setFullyOperationalDescription(rs.getString(13));
					e.setTimeIn(rs.getString(14));
					e.setTimeOut(rs.getString(15));
					e.setDateInstalled(rs.getString(16));

					list.add(e);
				}
				return list;
			}

		});

	}

	// Retrieve All Installation Certificates by ID

	public InstallationCertificate getAllInstallationCertificateByID(int id) {

		return template.query("select * from installation_certificate where installationID=" + id,
				new ResultSetExtractor<InstallationCertificate>() {
					public InstallationCertificate extractData(ResultSet rs) throws SQLException, DataAccessException {

						InstallationCertificate e = new InstallationCertificate();
						while (rs.next()) {

							e.setInstallationID(rs.getInt(1));
							e.setInstallationCode(rs.getString(3));
							e.setOrdId(rs.getString(4));
							e.setClienId(rs.getString(5));
							e.setTechId(rs.getString(6));
							e.setDrivId(rs.getString(7));
							e.setCableLen(rs.getDouble(8));
							e.setConduitLen(rs.getDouble(9));
							e.setSwInstalled(rs.getString(10));
							e.setSwInstalledDescription(rs.getString(11));
							e.setOpTraining(rs.getString(12));
							e.setOpTrainingDescription(rs.getString(13));
							e.setFullyOperational(rs.getString(14));
							e.setFullyOperationalDescription(rs.getString(15));
							e.setTimeIn(rs.getString(16));
							e.setTimeOut(rs.getString(17));
							e.setDateInstalled(rs.getString(18));

							/*
							 * e.setInstallationID(rs.getInt(1)); e.setOrdId(rs.getInt(2));
							 * e.setClienId(rs.getInt(3)); e.setTechId(rs.getInt(4));
							 * e.setDrivId(rs.getInt(5)); e.setCableLen(rs.getDouble(6));
							 * e.setConduitLen(rs.getDouble(7)); e.setSwInstalled(rs.getString(8));
							 * e.setSwInstalledDescription(rs.getString(9));
							 * e.setOpTraining(rs.getString(10));
							 * e.setOpTrainingDescription(rs.getString(11));
							 * e.setFullyOperational(rs.getString(12));
							 * e.setFullyOperationalDescription(rs.getString(13));
							 * e.setTimeIn(rs.getString(14)); e.setTimeOut(rs.getString(15));
							 * e.setDateInstalled(rs.getString(16));
							 */

						}
						return e;
					}

				});
	}

	// Delete Installation Certificate By ID

	public void delete(int id) {

		String sql = "delete from installation_device where instID=" + id + "";
		String sql2 = "delete from installation_certificate where installationID=" + id + "";

		System.out.println("Delete by ID" + sql + sql2);

		template.batchUpdate(sql, sql2);

	}

	// Delete All Installation Certificates

	public void delete() {
		String sql = "delete  from installation_device";
		String sql2 = "delete from installation_certificate where installationID>0";
		System.out.println("Delete ALL" + sql + sql2);
		template.batchUpdate(sql, sql2);
	}

	// Update Values in Installation Certificate
	public void update(InstallationCertificate ic, String code) {
		String sql = "update installation_certificate set ordId='" + ic.getOrdId() + "', clienId ='" + ic.getClienId()
				+ "',techId='" + ic.getTechId() + "',drivId='" + ic.getDrivId() + "',cableLen=" + ic.getCableLen()
				+ ",conduitLen=" + ic.getConduitLen() + ",swInstalled='" + ic.getSwInstalled() + "'"
				+ ",swInstalledDescription='" + ic.getSwInstalledDescription() + "',opTraining='" + ic.getOpTraining()
				+ "',opTrainingDescription='" + ic.getOpTrainingDescription() + "',fullyOperational='"
				+ ic.getFullyOperational() + "',fullyOperationalDescription='" + ic.getFullyOperationalDescription()
				+ "',timeIn='" + ic.getTimeIn() + "',timeOut='" + ic.getTimeOut() + "',dateInstalled='"
				+ ic.getDateInstalled() + "' where installationCode ='" + code + "'";

		template.update(sql);

		System.out.println("Dao update method" + ic.getInstallationID());
		System.out.println("Update Issue" + sql);
	}
	
	
	// Delete Add Items By ID

		public void deleteitemsbyid(int id) {

			String sql = "delete from installation_device where instID= '" + id + "'";
			
			System.out.println("Delete by ID" + sql);

			template.update(sql);

		}
	
	

}
