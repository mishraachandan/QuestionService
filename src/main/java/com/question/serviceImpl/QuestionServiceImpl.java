package com.question.serviceImpl;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Sorry, this id is not valid."));
    }

    @Override
    public List<Question> getQuestionByQuizId(Long id){
        return questionRepository.findByQuizId(id);
    }
}
