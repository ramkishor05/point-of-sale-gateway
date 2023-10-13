package com.brijframework.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.inventory.entities.EOCustIngredient;

@Repository
@Transactional
public interface CustIngredientRepository extends JpaRepository<EOCustIngredient, Long>{
	
	EOCustIngredient findOneByCusIinventoryAppIdAndTypeId(long custProductionAppId, String typeId);

	List<EOCustIngredient> findAllByCusIinventoryAppId(long custProductionAppId);

	EOCustIngredient findByCusIinventoryAppIdAndTypeId(long custProductionAppId, String typeId);

}
