package service;

import com.example.board.dto.BoardRequestDTO;
import com.example.board.dto.BoardResponseDTO;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Service {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDTO create(BoardRequestDTO dto) {
        Board board = new Board();
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setWriter(dto.getWriter());
        Board saved = boardRepository.save(board);
        return new BoardResponseDTO(saved);
    }

    public List<BoardResponseDTO> getAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<BoardResponseDTO> getById(Long id) {
        return boardRepository.findById(id).map(BoardResponseDTO::new);
    }

    public BoardResponseDTO update(Long id, BoardRequestDTO dto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setWriter(dto.getWriter());
        Board updated = boardRepository.save(board);
        return new BoardResponseDTO(updated);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
