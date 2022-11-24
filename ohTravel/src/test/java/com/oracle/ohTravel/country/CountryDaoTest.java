package com.oracle.ohTravel.country;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.ohTravel.country.dao.CountryDao;
import com.oracle.ohTravel.country.model.CountryDTO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest // 스프링 부트 띄우고 테스트(이게 없으면 @Autowired 다 실패)
@Transactional // 반복 가능한 테스트 지원, 각각의 테스트를 실행할 때마다 트랜잭션을 시작하고 테스트가 끝나면 트랜잭션을 강제로 롤백 (이 어노테이션이 테스트 케이스에서 사용될 때만 롤백)**
@Slf4j
public class CountryDaoTest {
	@Autowired
	CountryDao countryDao;
	
	@Test
	public void selectCountryByCountryIdTest() {
		List<CountryDTO> list = countryDao.selectCountryByCountryId(100);
		log.info("list="+list);
		assertTrue(list.size()==3);
	}
}
