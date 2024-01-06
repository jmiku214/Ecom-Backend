package com.ecom.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import liquibase.pro.packaged.F;

@SpringBootApplication
public class EcomLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomLoginServiceApplication.class, args);
		List<String> name = Arrays.asList("A", "A", "B", "C", "C", "C");
		List<NameClass> listNames = name.stream().map(e -> new NameClass(e)).collect(Collectors.toList());
		List<?> list = listNames.stream()
				.filter(e -> Collections.frequency(Arrays.asList(e.getName()), e) > 1).collect(Collectors.toList());
		System.err.println(name.stream().filter(e -> e.equals(name.iterator().next())).count());
//		System.out.println(name.stream().distinct().collect(Collectors.toList()));
//		Map<String, Integer> duplicateCount = new HashMap<>();
//		listNames.stream().forEach(e -> duplicateCount.merge(e.getName(), 1, (a, b) -> a + b));
//		System.err.println(duplicateCount);
		System.out.println(list);

	}

}

class NameClass {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NameClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NameClass(String name) {
		super();
		this.name = name;
	}
	
}