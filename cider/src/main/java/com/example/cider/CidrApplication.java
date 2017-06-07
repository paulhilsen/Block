package com.example.cider;

		import com.example.cider.DBConnection.ConnectionFactory;
        import com.example.cider.NextIPBlockFactory.NextIpBlock;
        import com.example.cider.dao.impl.DatabaseCheck;
        import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CidrApplication {

	public static void main(String[] args) {   SpringApplication.run(CidrApplication.class, args);











//
//
//                  //Test Database Connection//
//                ConnectionFactory connectionFactory = new ConnectionFactory();
//                DatabaseCheck databaseCheck = new DatabaseCheck();
//                databaseCheck.setJdbcTemplate(connectionFactory.databaseConnection());
//                System.out.println("With this id the block is = " + databaseCheck.checkifExist(2));
//
//                    NextIpBlock nextIpBlock = new NextIpBlock();
//                    nextIpBlock.returnIp(1,1);

    }
}
