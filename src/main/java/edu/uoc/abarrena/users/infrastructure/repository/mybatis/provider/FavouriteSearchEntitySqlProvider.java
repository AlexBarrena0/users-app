package edu.uoc.abarrena.users.infrastructure.repository.mybatis.provider;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.FavouriteSearchEntity;

public class FavouriteSearchEntitySqlProvider {

    public String findByDestinationIdAndDates(FavouriteSearchEntity favouriteSearchEntity) {
        String sql = "SELECT TRAVELER_ID FROM FAVOURITE_SEARCH WHERE " +
                "DESTINATION_ID = #{destinationId} AND START_DATE = #{startDate} AND END_DATE = #{endDate} " +
                "OR DESTINATION_ID = #{destinationId} AND START_DATE = #{startDate} AND END_DATE IS NULL " +
                "OR DESTINATION_ID = #{destinationId} AND START_DATE IS NULL AND END_DATE = #{endDate} " +
                "OR DESTINATION_ID = #{destinationId} AND START_DATE IS NULL AND END_DATE IS NULL " +
                "OR DESTINATION_ID IS NULL AND START_DATE = #{startDate} AND END_DATE = #{endDate} " +
                "OR DESTINATION_ID IS NULL AND START_DATE = #{startDate} AND END_DATE IS NULL " +
                "OR DESTINATION_ID IS NULL AND START_DATE IS NULL AND END_DATE = #{endDate} ";
        return sql;
    }
}
