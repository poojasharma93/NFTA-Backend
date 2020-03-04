package com.nfta.stopsTransaction.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.TransactionService;

@RestController
@RequestMapping("/")
public class TransactionController {

	@Autowired
	TransactionService service;

	@Autowired
	SearchFilters searchFilters;

	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public @ResponseBody String getTransactions(@RequestParam(value ="id", required = false) String stopId,
			@RequestParam(value ="location", required = false) String location, @RequestParam(value ="direction", required = false) String direction,
			@RequestParam(value ="country", required = false) String country, @RequestParam(value ="dateFrom", required = false) String dateFrom,
			@RequestParam(value ="dateTo", required = false) String dateTo) {
		List<StopTransactions> list = new ArrayList<>();
		try {

			setSearchFilter(stopId, location, direction, country, dateFrom, dateTo);
			list = service.getTransactions(searchFilters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
		//return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public @ResponseBody String getTransactions() {
		List<StopTransactions> list = new ArrayList<>();
		try {
			list = service.getAllTransactions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
		//return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * 
	 * It can handle add and update both need to decide further on functionalities
	 * 
	 * @param stopTransaction
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody String addTransaction(@RequestBody StopTransactions stopTransaction) {
		String json = "";
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(json);
	}

	private void setSearchFilter(String stopId, String location, String direction, String country, String dateFrom,
			String dateTo) {
		searchFilters.setCountry(country);
		searchFilters.setDateFrom(dateFrom);
		searchFilters.setDateTo(dateTo);
		searchFilters.setDirection(direction);
		searchFilters.setLocation(location);
		searchFilters.setStopID(stopId);
	}

}
