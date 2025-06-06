package core.basesyntax.dao.animal;

import core.basesyntax.dao.AbstractDao;
import core.basesyntax.model.zoo.Animal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AnimalDaoImpl extends AbstractDao implements AnimalDao {
    public AnimalDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Animal save(Animal animal) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(animal);
            transaction.commit();
            return animal;
        } catch (Exception e) {
            throw new RuntimeException("Can't save animal to the DB!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Animal> findByNameFirstLetter(Character character) {
        try (Session session = sessionFactory.openSession()) {
            String parameter = character + "%";
            return session.createQuery("FROM Animal a"
                            + " WHERE lower(a.name) LIKE :pattern ", Animal.class)
                    .setParameter("pattern", parameter.toLowerCase())
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't find animals with starts with "
                    + "character " + character);
        }
    }
}
