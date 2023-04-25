namespace java com.github

// Note that Order of declaration matters

struct Product {
  1: required double weight,
  2: required string name
}

struct Cargo {
  1: required list<Product> products;
  2: required bool isUrgent
  3: required DeliveryType deliveryType
}

const double CARGO_WEIGHT_LIMIT = 5000;

enum DeliveryType {
    BY_SEA,
    BY_TRAIN,
    BY_PLAIN,
    BY_TRUCK
}

enum DeliveryStatus {
    NOT_FOUND,
    CREATED,
    IN_PROGRESS,
    DELIVERED
}

exception EmptyCargoException {}

exception CargoWeigtExceededException {}

service BaseService {
    string ping()
}

service CargoService extends BaseService {

    string calculateShippingCost(1: Cargo cargo) throws (1: EmptyCargoException emptyException, 2: CargoWeigtExceededException weightException);

    i64 sendCargo(1: Cargo cargo) throws (1: EmptyCargoException emptyException, 2: CargoWeigtExceededException weightException);

    DeliveryStatus checkStatusById(1: i64 id);

}