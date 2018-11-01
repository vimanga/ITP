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

import com.example.demo.model.SalesManagement.ClientOrderSales;
import com.example.demo.model.EmployeeManagement.Employee;
import com.example.demo.model.SalesManagement.InstallationCertificate;
import com.example.demo.model.SalesManagement.Sales;
import com.google.zxing.Result;


@Service
public class SalesDAO {
	JdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
//------------------------------------------------------------Technician-----------------------------------------------------------
//Assign Technician
	public Sales saveTech(Sales s,int id) {
		
		String sql = "SET @var = (select client_order_code from client_order where clieOrdID = " + id+ ")";
		String sql2 = "insert into sales(orID,techID) values(@var,'"+s.getTechID()+"')";
		
		//String sql2 = "update sales SET techID ='"+s.getTechID()+"' where orID=@var";
		System.out.println("NEW NEW NEW NEW :"+s.getTechID());
		String sql3 =  "update sales SET salesCode = concat(salesPrefix,salesID)";
		String sql5 = "update other_emps set availability = '0' where empCode = '"+s.getTechID()+"';";

		String sql6 = "SET @var2 = (select client_order_code from client_order where clieOrdID = "+id+");"; 
		String sql7 = "update sales s, client_order co set s.technician_assign_status = '1' where s.orID = @var2;"; 
		
		System.out.println(sql+sql2+sql3+sql5);
		
		template.batchUpdate(sql, sql2, sql3,sql5,sql6,sql7);
		System.out.println("SQL5----"+sql5);
		
		
////////////////////
		String sql4="select email from employee where empcode ='"+s.getTechID()+"';";
		System.out.println("SQL4"+sql4);		
		
		
				//return template.query("select e.email from employee e,sales s,client_order co where s.techID = e.empcode and s.orID='CO9' and s.orID = co.client_orderCode",
				return template.query(sql4,new ResultSetExtractor<Sales>() {
							public Sales extractData(ResultSet rs) throws SQLException, DataAccessException {

								//Sales e = new Sales();
								while (rs.next()) {

									s.setEmail(rs.getString(1));
								System.out.println("Inside while loop get"+s.getEmail());
							

								}
								
							
								
								return s;
							}

						});
}
	
	

	// Retrieve Technicians

	public List<Employee> getAllAvailableTechnicians() {
		
		return template.query("select e.empcode,e.firstName,e.lastName,e.experiencedLevel,e.email,e.contactNo1,e.contactNo2, oe.bikeNo from employee e, other_emps oe where e.designation='Technician' AND oe.availability=1 AND  e.empID=oe.empOTId;", new ResultSetExtractor<List<Employee>>() {
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Employee> list = new ArrayList<Employee>();

				while (rs.next()) {

					Employee e = new Employee();

					
					e.setEmployeeCode(rs.getString(1));
					e.setFirstName(rs.getString(2));
					e.setLastName(rs.getString(3));
					e.setExperiencedLevel(rs.getInt(4));
					e.setEmail(rs.getString(5));
					e.setContactNo1(rs.getInt(6));
					e.setContactNo2(rs.getInt(7));
					e.setBikeNo(rs.getString(8));
					
					list.add(e);
				}
				return list;
			}

		});

	}
	
//----------------------------------------------------------------Driver----------------------------------------------------------------
/* //Assign Driver
		public void saveDrive(Sales s,int id) {
			
			
			String sql="SET @var = (select client_orderCode from client_order where clieOrdID = "+ id+ ")";
			String sql2 = "update sales SET driverID ='"+s.getDriverID()+"' where orID=@var";
			
			System.out.println(sql);
			System.out.println(sql2);
			template.batchUpdate(sql, sql2);
			
			//template.update(sql);
		}*/
	
//Assign Driver
		public Sales saveDrive(Sales s,int id) {
			
			String sql = "SET @var = (select client_order_code from client_order where clieOrdID = " + id+ ")";
			String sql2 = "update sales SET driverID ='"+s.getDriverID()+"' where orID=@var";
			String sql3 = "update other_emps set availability = '0' where empCode = '"+s.getDriverID()+"';";
			//String sql2 = "update sales SET techID ='"+s.getTechID()+"' where orID=@var";
			String sql6 = "SET @var2 = (select client_order_code from client_order where clieOrdID = "+id+");"; 
			String sql7 = "update sales s, client_order co set s.driver_assign_status = '1' where s.orID = @var2;"; 
			
			
			template.batchUpdate(sql, sql2,sql3,sql6,sql7);
			//String sql4="select email from employee where empid ="+s.getTechID();
			//String sql4 =	"SET @email=(select e.email from employee e,sales s,client_order co where s.techID = e.empcode and s.orID='CO9' and s.orID = co.client_orderCode);";
			
			//System.out.println(sql4);
			
			String sql4="select email from employee where empcode ='"+s.getDriverID()+"';";
		
			System.out.println("SQL4"+sql4);		
			
			
					//return template.query("select e.email from employee e,sales s,client_order co where s.techID = e.empcode and s.orID='CO9' and s.orID = co.client_orderCode",
					return template.query(sql4,new ResultSetExtractor<Sales>() {
								public Sales extractData(ResultSet rs) throws SQLException, DataAccessException {

									//Sales e = new Sales();
									while (rs.next()) {

										s.setEmail(rs.getString(1));
									System.out.println("Inside while loop get"+s.getEmail());
								

									}
									
								
									
									return s;
								}

							});
					
		}

// Retrieve Driver

		public List<Employee> getAllAvailableDrivers() {
			
			return template.query("select e.empcode,e.firstName,e.lastName,e.experiencedLevel,e.email,e.contactNo1,e.contactNo2, oe.vehicleNo from employee e, other_emps oe where e.designation='Driver' AND oe.availability=1 AND  e.empID=oe.empOTId;", new ResultSetExtractor<List<Employee>>() {
				public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

					List<Employee> list = new ArrayList<Employee>();

					while (rs.next()) {

						Employee e = new Employee();

						
						e.setEmployeeCode(rs.getString(1));
						e.setFirstName(rs.getString(2));
						e.setLastName(rs.getString(3));
						e.setExperiencedLevel(rs.getInt(4));
						e.setEmail(rs.getString(5));
						e.setContactNo1(rs.getInt(6));
						e.setContactNo2(rs.getInt(7));
						e.setVehicleNo(rs.getString(8));
						
						list.add(e);
					}
					return list;
				}

			});

		}
		
	
	
	
	
	
	
//------------------------------------------------------------Sales-------------------------------------------------------------------
		
		
			
// Retrieve All Sales Details
		public List<Sales> getAllSalesDetails() {

			return template.query("select * from Sales",
					new ResultSetExtractor<List<Sales>>() {
						public List<Sales> extractData(ResultSet rs)
								throws SQLException, DataAccessException {

							List<Sales> list = new ArrayList<Sales>();

							while (rs.next()) {
						
								Sales e = new Sales();
								e.setSalesID(rs.getInt(2));
								e.setSalesCode(rs.getString(3));
								e.setStatus(rs.getString(4));
								e.setDateCompleted(rs.getString(5));
								e.setTechID(rs.getString(6));
								e.setDriverID(rs.getString(7));
								e.setTotalAmount(rs.getDouble(8));
								e.setOrID(rs.getString(9));
								e.setPayment_status(rs.getBoolean(10));
								e.setTechnician_assign_status(rs.getBoolean(11));
								e.setDriver_assign_status(rs.getBoolean(12));
								list.add(e);
							}
							return list;
						}

					});

		}
	
	
	
//Generate Total Amount by id
	public void generateAmountByID(int id) {

			
			String sql = "SET @VAR = (select SUM(id.quantity * d.unitPrice) from installation_device id,device d ,sales s,client_order co,installation_certificate ic where id.devicesCode = d.deviceCode AND s.orID= co.client_order_code AND ic.ordId=co.client_order_code AND id.instID=ic.installationID AND s.salesID="+id+");"; 
					 
			String sql2 = "update sales SET totalAmount = @var  where salesID= "+id+" ";
			System.out.println("Generate Total Amount sql1 " + sql);
			System.out.println("Generate Total Amount sql2 " + sql2);
			template.batchUpdate(sql,sql2);

		}	
		
//Update status completed by id
	public void updateStatusCompletedByID(int id) {

		
			 String sql= "update sales SET status = 'Completed',dateCompleted=current_date()  where salesID= "+id+" ";
			 String sql2 = "update other_emps oe,sales s set oe.availability = '1' where s.techID = oe.empCode AND s.salesID = "+id+" ";
			 String sql3 ="update other_emps oe,sales s set oe.availability = '1' where s.driverID = oe.empCode AND s.salesID = "+id+" ";
			
			// System.out.println("Update status completed" + sql + sql2 + sql3);
			
			template.batchUpdate(sql,sql2,sql3);

			//template.update(sql);

		}	

//Update status Pending by id
		public void updateStatusPendingByID(int id) {

			
			 String sql= "update sales SET status = 'Pending',dateCompleted= null  where salesID= "+id+" ";
			 String sql2 = "update other_emps oe,sales s set oe.availability = '0' where s.techID = oe.empCode AND s.salesID = "+id+" ";
			 String sql3 ="update other_emps oe,sales s set oe.availability = '0' where s.driverID = oe.empCode AND s.salesID = "+id+" ";
			 

			 System.out.println("Now Check SQL "+sql);
			 System.out.println("Now Check SQL2"+sql2);
			 System.out.println("Now Check SQL3"+sql3);
			 template.batchUpdate(sql,sql2,sql3);
			//template.update(sql);

			}	
//Update Payment Status by id
		public void updateStausPayment(int id) {

			  String sql = "update sales set payment_status = '1' where salesID = "+id+"";
			  System.out.println("SQL = "+sql);
			  //String sql1= "update sales SET status = 'Pending',dateCompleted= null  where salesID= "+id+" ";
			
			template.update(sql);

		}	
		

//Delete Sales details By ID
		
		public void delete(int id) {

			String sql = "update other_emps oe,sales s set oe.availability = '1' where s.techID = oe.empCode AND s.salesID = "+id+" ";
			String sql2 ="update other_emps oe,sales s set oe.availability = '1' where s.driverID = oe.empCode AND s.salesID = "+id+" ";
			 
			String sql3 = "delete from sales where salesID=" + id + "";
			//System.out.println("Update status completed" + sql+sql2+sql3);
			
			
			
			System.out.println("SQL ="+sql);
			System.out.println("SQL 1 ="+sql2);
			System.out.println("SQL 2="+sql3);
			template.batchUpdate(sql,sql2,sql3);
			//template.update(sql);

		}

		// Delete All Salesdetails
		public void delete() {
			
			String sql = "delete from sales where salesID>0";
			 //String sql2 = "update other_emps set availability = '1' where empCode = '"+s.getTechID()+"';";
			 //String sql3 = "update other_emps set availability = '1' where empCode = '"+s.getDriverID()+"';";
			//System.out.println("Update status completed" + sql+sql2+sql3);
			
			//template.batchUpdate(sql,sql2,sql3);
			
			template.update(sql);

		}
		
		
		
		
	
//Get Pending Orders for the day 
		
		
		// Retrieve All Sales Details
				public List<Sales> getPendingSalesDetails() {

					return template.query("select * from sales where status = 'Pending';",
							new ResultSetExtractor<List<Sales>>() {
								public List<Sales> extractData(ResultSet rs)
										throws SQLException, DataAccessException {

									List<Sales> list = new ArrayList<Sales>();

									while (rs.next()) {
								
										Sales e = new Sales();
										e.setSalesID(rs.getInt(2));
										e.setSalesCode(rs.getString(3));
										e.setStatus(rs.getString(4));
										e.setDateCompleted(rs.getString(5));
										e.setTechID(rs.getString(6));
										e.setDriverID(rs.getString(7));
										e.setTotalAmount(rs.getDouble(8));
										e.setOrID(rs.getString(9));
										

										list.add(e);
									}
									return list;
								}

							});

				}
				
		/*		//Update Assign Technician Status by id
				public void updateStausAssignTechnician(int id) {

					String sq6 = "SET @VAR = (select client_order_code from client_order where clieOrdID = 1);"; 
					String sql7 = "update sales s, client_order co set s.technician_assign_status = '1' where s.orID = @var;"; 
					
					template.batchUpdate(sql,sql2);

				}
		//Update Assign Driver Status by id
						public void updateStausAssignDriver(int id) {
							String sql = "SET @VAR = (select client_order_code from client_order where clieOrdID = 1);"; 
							String sql2 = "update sales s, client_order co set s.driver_assign_status = '1' where s.orID = @var;"; 
							
							template.batchUpdate(sql,sql2);

						}		
				*/
				
				
				
			
}



