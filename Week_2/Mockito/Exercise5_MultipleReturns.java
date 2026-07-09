import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise5_MultipleReturns {
    @Test
    public void testMultipleReturns() {
        DataProvider mockProvider = Mockito.mock(DataProvider.class);
        
        // Stub multiple consecutive calls to return different values
        when(mockProvider.fetchData())
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenReturn("Third Call");
        
        DataService service = new DataService(mockProvider);
        
        // Verify different returns on consecutive calls
        String result1 = service.getData();
        String result2 = service.getData();
        String result3 = service.getData();
        
        assert result1.equals("First Call");
        assert result2.equals("Second Call");
        assert result3.equals("Third Call");
    }
    
    @Test
    public void testMultipleReturnsWithException() {
        APIClient mockClient = Mockito.mock(APIClient.class);
        
        // Stub to return value on first call, throw exception on second
        when(mockClient.callAPI())
            .thenReturn("Success")
            .thenThrow(new RuntimeException("API Error"));
        
        APIService service = new APIService(mockClient);
        
        // First call returns success
        String result1 = service.makeCall();
        assert result1.equals("Success");
        
        // Second call throws exception
        try {
            String result2 = service.makeCall();
        } catch (RuntimeException e) {
            assert e.getMessage().equals("API Error");
        }
    }
}

interface DataProvider {
    String fetchData();
}

interface APIClient {
    String callAPI();
}

class DataService {
    private DataProvider provider;
    
    public DataService(DataProvider provider) {
        this.provider = provider;
    }
    
    public String getData() {
        return provider.fetchData();
    }
}

class APIService {
    private APIClient client;
    
    public APIService(APIClient client) {
        this.client = client;
    }
    
    public String makeCall() {
        return client.callAPI();
    }
}
