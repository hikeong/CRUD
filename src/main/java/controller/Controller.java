package controller;

import com.example.board.dto.BoardRequestDTO;
import com.example.board.dto.BoardResponseDTO;
import com.example.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class Controller {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<BoardResponseDTO> create(@RequestBody BoardRequestDTO dto) {
        return ResponseEntity.ok(boardService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDTO>> getAll() {
        return ResponseEntity.ok(boardService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDTO> getById(@PathVariable Long id) {
        return boardService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResponseDTO> update(@PathVariable Long id, @RequestBody BoardRequestDTO dto) {
        return ResponseEntity.ok(boardService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.ok().build();
    }
}
