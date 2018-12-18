package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Event;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class EventMapperImpl implements EventMapper{
	private static final String namespace = "kr.or.yi.java_web_female.dao.EventMapper";
	private static final EventMapperImpl instance = new EventMapperImpl();
	
	public static EventMapperImpl getInstance() {
		return instance;
	}

	private EventMapperImpl() {
	}

	@Override
	public Event selectEventByNo(Event event) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectEventByNo", event);
		}
	}

	@Override
	public List<Event> selectEventByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectEventByAll");
		}
	}

	@Override
	public int insertEvent(Event event) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertEvent", event);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateEvent(Event event) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updateEvent", event);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteEvent(Event event) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteEvent", event);
			sqlSession.commit();
			return res;
		}
	}
	
	
}
