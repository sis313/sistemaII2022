package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.CommentDto;
import ucb.app.model.Comment;
import ucb.app.repository.CommentRepository;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDto> findAllDto() {
        return commentRepository.findAll().stream().map(this::commentToCommentDto).collect(Collectors.toList());
    }

    public CommentDto findByIdDto(Integer commentId) throws Exception {
        return commentRepository.findById(commentId).stream().map(this::commentToCommentDto).findFirst()
                .orElseThrow(() -> new Exception("Could not find comment"));
    }

    public List<CommentDto> findByBusinessIdDto(Integer businessId) {
        return commentRepository.findByIdBusiness(businessId).stream().map(this::commentToCommentDto)
                .collect(Collectors.toList());
    }

    // GRUPO 3 ROUTE
    public List<CommentDto> findByUserIdDto(Integer userId) {
        return commentRepository.findByIdUser(userId).stream().map(this::commentToCommentDto)
                .collect(Collectors.toList());
    }

    // GRUPO 3 ROUTE
    public List<CommentDto> findByUserIdAndCommentIdDto(Integer userId, Integer commentId) {
        return commentRepository.findByIdUserAndIdComment(userId, commentId).stream().map(this::commentToCommentDto)
                .collect(Collectors.toList());
    }

    public CommentDto saveDto(CommentDto commentDto) {
        Comment comment = new Comment(commentDto.getIdComment(), commentDto.getMessage(), commentDto.getIdUser(),
                commentDto.getIdBusiness(), commentDto.getStatus());
        Comment response = commentRepository.save(comment);
        return commentToCommentDto(response);
    }

    public CommentDto updateDto(Integer commentId, CommentDto commentDto) {
        Comment commentFound = commentRepository.getReferenceById(commentId);
        commentFound.setMessage(commentDto.getMessage());
        commentFound.setIdUser(commentDto.getIdUser());
        commentFound.setIdBusiness(commentDto.getIdBusiness());
        Comment response = commentRepository.save(commentFound);
        return commentToCommentDto(response);
    }

    public CommentDto deleteByIdDto(Integer commentId) {
        Comment commentFound = commentRepository.getReferenceById(commentId);
        commentFound.setStatus(commentFound.getStatus() < 1 ? 1 : 0);
        Comment response = commentRepository.save(commentFound);
        return commentToCommentDto(response);
    }

    private CommentDto commentToCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto(comment.getIdComment(), comment.getMessage(), comment.getIdUser(),
                comment.getIdBusiness(), comment.getStatus());
        return commentDto;
    }
}
