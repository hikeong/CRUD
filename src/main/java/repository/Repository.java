package repository;

import com.example.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Board, Long> {
}
