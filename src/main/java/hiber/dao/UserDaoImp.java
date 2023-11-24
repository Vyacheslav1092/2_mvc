package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   @Transactional
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @SuppressWarnings("unchecked")
   @Override
   @Transactional(readOnly = true)
   public List<User> listUsers() {
      return (List<User>) sessionFactory.getCurrentSession().createQuery("FROM User").getResultList();
   }

   @Override
   @Transactional
   public void deleteAllUsers() {
      sessionFactory.getCurrentSession().createQuery("DELETE FROM User").executeUpdate();
   }

   @Override
   @Transactional(readOnly = true)
   public Optional<User> findUserByCarNameAndSeries(String carName, String carSeries) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
              "SELECT u FROM User u JOIN FETCH u.car c WHERE c.name = :carName AND c.series = :carSeries",
              User.class);
      query.setParameter("carName", carName);
      query.setParameter("carSeries", carSeries);
      return query.getResultStream().findFirst();
   }
}
