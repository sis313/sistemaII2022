package ucb.edu.bo.tallersoftware.api;

import com.amazonaws.services.comprehend.model.SentimentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.tallersoftware.bl.ComprenhendBl;
import ucb.edu.bo.tallersoftware.dto.TextRequest;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class ComprehendApi {
    private ComprenhendBl comprenhendBl;

    @Autowired
    public ComprehendApi(ComprenhendBl comprenhendBl) {
        this.comprenhendBl = comprenhendBl;
    }

    @RequestMapping(value = "/sentiment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SentimentScore detectSentimentsWithComprehend(@RequestBody TextRequest text, HttpServletRequest request) {
//        Transactions transaction = TransactionUtil.createTransaction(request);
//        transactionBl.createTransaction(transaction);
        return comprenhendBl.detectsentiment(text);

    }
}
