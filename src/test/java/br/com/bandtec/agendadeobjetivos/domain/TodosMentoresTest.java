package br.com.bandtec.agendadeobjetivos.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosMentoresTest {

//	@Autowired
//	private TodosMentores todosMentores;
//
//	private Mentor mentor;
//
//	@Before
//	public void setUp() {
//		mentor = new Mentor("nome do mentor", "sua profissão");
//	}
//
//	@Test
//	public void persistirUmNovoMentor() {
//		todosMentores.save(mentor);
//		Mentor mentorPersistido = todosMentores.findById(mentor.getId()).get();
//
//		assertEquals(mentor, mentorPersistido);
//	}
}
