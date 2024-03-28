This maven library can be used to easily integrate surrealdb with springboot 
This is issue which this repository solves -> https://github.com/surrealdb/surrealdb.java/issues/82


I have created an implementation which will expect the following to use repository pattern  (The library still works as it is if this is not required) ->

1.  Configuration through application.properties (else it will take the default values, will add id and password as well) :


> surrealdb.host=localhost

> surrealdb.port=8000

> surrealdb.useSsl=false

> surrealdb.nameSpace=test

> surrealdb.database=test


2.  Entity Annotation with @SurrealTable and @SurrealId: Entities can now be annotated to define document/table mappings and identifiers, simplifying the mapping process. For example:

```
@SurrealTable("parent_route")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ParentRoute {

    @SurrealId
    private String id;
    private Long validFrom;
    private Long validTo;
    private String client;
    private String rId;

 } 
```

3. CRUD Operations through SurrealCrudRepository: Entities can extend the SurrealCrudRepository interface to enable CRUD operations, streamlining data manipulation tasks:

```
@Repository
public interface ParentRouteRepository extends SurrealCrudRepository<ParentRoute,String> {
}
```

4. Custom Queries with @SurrealQuery: Similar to JPA's @Query annotation, @SurrealQuery enables the execution of custom queries, providing flexibility in data retrieval:

```
@Repository
public interface ParentRouteRepository extends SurrealCrudRepository<ParentRoute,String> {

    @SurrealQuery("select * from parent_route where client = ?1 and rId = ?2 ;")
    ParentRoute findByRouteIdAndBuid(String client, String rId);
    
    
    @SurrealQuery("select *, ->hasData->(r_data where time = ?1 ).*->hasVehicle->vehicle_detail.* as vehicle from parent_route where client = ?2 and rId = ?3 ;")
    List<ParentRoutePrj> findShuttleRouteByStartTimeAndBuidAndRouteId(long time, String client, String rId);
    
}
```

Extra feature in first cut -> 
If we want a field to have a sequence we can use @SurrealSequenceId(sequenceName = "rIdSequence") : This will give that field a numeric sequence (with string-type fields being appropriately casted).
