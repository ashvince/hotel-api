package uk.ashvince.hotelapi.config;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.TableNameOverride;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import lombok.extern.apachecommons.CommonsLog;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import uk.ashvince.hotelapi.repository.HotelRepository;

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = {HotelRepository.class})
@CommonsLog
public class DynamoDbConfig {

  @Value("${amazon.dynamodb.table.prefix}")
  private String tablePrefix;

  /**
   * Config DI Method.
   *
   * @return configured DynamoDBMapperConfig for project.
   */
  @Bean
  @Primary
  public DynamoDBMapperConfig dynamoDBMapperConfig() {

    log.info(String.format("Using DynamoDB store prefix: %s", tablePrefix));

    return DynamoDBMapperConfig.builder()
        .withTableNameOverride(TableNameOverride.withTableNamePrefix(
            String.format("%s-", tablePrefix)
        ))
        .build();
  }

  /**
   * Config DI Method.
   *
   * @return configured AmazonDynamoDB for project.
   */
  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    return AmazonDynamoDBClientBuilder
        .standard()
        .withRegion(Regions.EU_WEST_1)
        .build();
  }

  /**
   * Config DI Method.
   *
   * @return configured DynamoDB for project.
   */
  @Bean
  public DynamoDB dynamoDB(AmazonDynamoDB amazonDynamoDB) {
    return new DynamoDB(amazonDynamoDB);
  }

}
