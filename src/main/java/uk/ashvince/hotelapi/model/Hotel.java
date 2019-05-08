package uk.ashvince.hotelapi.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBGeneratedUuid;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

  @Id
  @DynamoDBHashKey
  @DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
  private String id;

  @DynamoDBAttribute
  private String name;
}
