package com.example.yujuancarlos_dev.emarctest.network;

import com.example.yujuancarlos_dev.emarctest.CustomRobolectricTestRunner;
import com.example.yujuancarlos_dev.emarctest.rx.TestTrampolineSchedulerProvider;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by yujuancarlos_dev on 14/03/2018.
 */

@RunWith(CustomRobolectricTestRunner.class)
public class NetworkRepositoryTest {
  @Rule
  public MockitoRule rule = MockitoJUnit.rule();
  @Mock
  public ImageApi imageApi;
  @InjectMocks
  public NetworkRepository networkRepository;

  private TestTrampolineSchedulerProvider scheduler = new TestTrampolineSchedulerProvider();

  @Test
  public void testGetImages() {
    List<String> testResponse = new ArrayList<>();
    testResponse.add("TEST");

    when(imageApi.getImageList(anyInt())).thenReturn(Single.just(testResponse));

    TestObserver<List<String>> testObserver  = networkRepository.getImages(0)
        .subscribeOn(scheduler.ui()).observeOn(scheduler.ui())
        .test();

    testObserver.assertValue(testResponse);
    List<List<Object>> events = testObserver.getEvents();
    List<Object> onNext = events.get(0);
    List<Object> onError = events.get(1);
    List<Object> onComplete = events.get(2);

    assertTrue("More than one on next emitted", onNext.size() == 1);
    assertTrue("Error emitted", onError.size() == 0);
    assertTrue("Error emitted", onComplete.size() == 1);

    int count = testObserver.valueCount();
    assertEquals("More than one emission", 1, count);
  }
}
