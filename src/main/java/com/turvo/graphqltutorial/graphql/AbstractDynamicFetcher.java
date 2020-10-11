package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.model.MyCacheable;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.util.ReflectionUtils;

@AllArgsConstructor
public abstract class AbstractDynamicFetcher<T extends MyCacheable, ID> implements DynamicFetcher<T, ID>{

  private final MongoRepository<T, ID> repository;
  private final CacheManager cacheManager;

  @Override
  public Optional<T> retrieve(ID id, DynamicallyUpdatedSource source) {
      if(source == DynamicallyUpdatedSource.DB_UPDATED){
        Optional<T> value = retriveFromDB(id);
        cacheManager.getCache(T.cacheName()).put(id, value.orElse(null));
        return value;
      }
      return Optional.ofNullable((T)cacheManager.getCache(T.cacheName()).get(id).get());
  }

  public Optional<T> retriveFromDB(ID id){
    return repository.findById(id);
  }
}
