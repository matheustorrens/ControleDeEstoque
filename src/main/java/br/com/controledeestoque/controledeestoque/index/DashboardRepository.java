package br.com.controledeestoque.controledeestoque.index;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardModel, Long> {
    @SuppressWarnings("null")
    List<DashboardModel> findAll();
}