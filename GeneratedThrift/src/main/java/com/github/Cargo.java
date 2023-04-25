/**
 * Autogenerated by Thrift Compiler (0.18.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.github;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.18.1)", date = "2023-04-24")
public class Cargo implements org.apache.thrift.TBase<Cargo, Cargo._Fields>, java.io.Serializable, Cloneable, Comparable<Cargo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Cargo");

  private static final org.apache.thrift.protocol.TField PRODUCTS_FIELD_DESC = new org.apache.thrift.protocol.TField("products", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField IS_URGENT_FIELD_DESC = new org.apache.thrift.protocol.TField("isUrgent", org.apache.thrift.protocol.TType.BOOL, (short)2);
  private static final org.apache.thrift.protocol.TField DELIVERY_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("deliveryType", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CargoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CargoTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<Product> products; // required
  public boolean isUrgent; // required
  public @org.apache.thrift.annotation.Nullable DeliveryType deliveryType; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PRODUCTS((short)1, "products"),
    IS_URGENT((short)2, "isUrgent"),
    DELIVERY_TYPE((short)3, "deliveryType");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PRODUCTS
          return PRODUCTS;
        case 2: // IS_URGENT
          return IS_URGENT;
        case 3: // DELIVERY_TYPE
          return DELIVERY_TYPE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ISURGENT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PRODUCTS, new org.apache.thrift.meta_data.FieldMetaData("products", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Product.class))));
    tmpMap.put(_Fields.IS_URGENT, new org.apache.thrift.meta_data.FieldMetaData("isUrgent", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.DELIVERY_TYPE, new org.apache.thrift.meta_data.FieldMetaData("deliveryType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.ENUM        , "DeliveryType")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Cargo.class, metaDataMap);
  }

  public Cargo() {
  }

  public Cargo(
    java.util.List<Product> products,
    boolean isUrgent,
    DeliveryType deliveryType)
  {
    this();
    this.products = products;
    this.isUrgent = isUrgent;
    setIsUrgentIsSet(true);
    this.deliveryType = deliveryType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Cargo(Cargo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetProducts()) {
      java.util.List<Product> __this__products = new java.util.ArrayList<Product>(other.products.size());
      for (Product other_element : other.products) {
        __this__products.add(new Product(other_element));
      }
      this.products = __this__products;
    }
    this.isUrgent = other.isUrgent;
    if (other.isSetDeliveryType()) {
      this.deliveryType = other.deliveryType;
    }
  }

  @Override
  public Cargo deepCopy() {
    return new Cargo(this);
  }

  @Override
  public void clear() {
    this.products = null;
    setIsUrgentIsSet(false);
    this.isUrgent = false;
    this.deliveryType = null;
  }

  public int getProductsSize() {
    return (this.products == null) ? 0 : this.products.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<Product> getProductsIterator() {
    return (this.products == null) ? null : this.products.iterator();
  }

  public void addToProducts(Product elem) {
    if (this.products == null) {
      this.products = new java.util.ArrayList<Product>();
    }
    this.products.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<Product> getProducts() {
    return this.products;
  }

  public Cargo setProducts(@org.apache.thrift.annotation.Nullable java.util.List<Product> products) {
    this.products = products;
    return this;
  }

  public void unsetProducts() {
    this.products = null;
  }

  /** Returns true if field products is set (has been assigned a value) and false otherwise */
  public boolean isSetProducts() {
    return this.products != null;
  }

  public void setProductsIsSet(boolean value) {
    if (!value) {
      this.products = null;
    }
  }

  public boolean isIsUrgent() {
    return this.isUrgent;
  }

  public Cargo setIsUrgent(boolean isUrgent) {
    this.isUrgent = isUrgent;
    setIsUrgentIsSet(true);
    return this;
  }

  public void unsetIsUrgent() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ISURGENT_ISSET_ID);
  }

  /** Returns true if field isUrgent is set (has been assigned a value) and false otherwise */
  public boolean isSetIsUrgent() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ISURGENT_ISSET_ID);
  }

  public void setIsUrgentIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ISURGENT_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public DeliveryType getDeliveryType() {
    return this.deliveryType;
  }

  public Cargo setDeliveryType(@org.apache.thrift.annotation.Nullable DeliveryType deliveryType) {
    this.deliveryType = deliveryType;
    return this;
  }

  public void unsetDeliveryType() {
    this.deliveryType = null;
  }

  /** Returns true if field deliveryType is set (has been assigned a value) and false otherwise */
  public boolean isSetDeliveryType() {
    return this.deliveryType != null;
  }

  public void setDeliveryTypeIsSet(boolean value) {
    if (!value) {
      this.deliveryType = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case PRODUCTS:
      if (value == null) {
        unsetProducts();
      } else {
        setProducts((java.util.List<Product>)value);
      }
      break;

    case IS_URGENT:
      if (value == null) {
        unsetIsUrgent();
      } else {
        setIsUrgent((java.lang.Boolean)value);
      }
      break;

    case DELIVERY_TYPE:
      if (value == null) {
        unsetDeliveryType();
      } else {
        setDeliveryType((DeliveryType)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PRODUCTS:
      return getProducts();

    case IS_URGENT:
      return isIsUrgent();

    case DELIVERY_TYPE:
      return getDeliveryType();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case PRODUCTS:
      return isSetProducts();
    case IS_URGENT:
      return isSetIsUrgent();
    case DELIVERY_TYPE:
      return isSetDeliveryType();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof Cargo)
      return this.equals((Cargo)that);
    return false;
  }

  public boolean equals(Cargo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_products = true && this.isSetProducts();
    boolean that_present_products = true && that.isSetProducts();
    if (this_present_products || that_present_products) {
      if (!(this_present_products && that_present_products))
        return false;
      if (!this.products.equals(that.products))
        return false;
    }

    boolean this_present_isUrgent = true;
    boolean that_present_isUrgent = true;
    if (this_present_isUrgent || that_present_isUrgent) {
      if (!(this_present_isUrgent && that_present_isUrgent))
        return false;
      if (this.isUrgent != that.isUrgent)
        return false;
    }

    boolean this_present_deliveryType = true && this.isSetDeliveryType();
    boolean that_present_deliveryType = true && that.isSetDeliveryType();
    if (this_present_deliveryType || that_present_deliveryType) {
      if (!(this_present_deliveryType && that_present_deliveryType))
        return false;
      if (!this.deliveryType.equals(that.deliveryType))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetProducts()) ? 131071 : 524287);
    if (isSetProducts())
      hashCode = hashCode * 8191 + products.hashCode();

    hashCode = hashCode * 8191 + ((isUrgent) ? 131071 : 524287);

    hashCode = hashCode * 8191 + ((isSetDeliveryType()) ? 131071 : 524287);
    if (isSetDeliveryType())
      hashCode = hashCode * 8191 + deliveryType.getValue();

    return hashCode;
  }

  @Override
  public int compareTo(Cargo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetProducts(), other.isSetProducts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProducts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.products, other.products);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetIsUrgent(), other.isSetIsUrgent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsUrgent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isUrgent, other.isUrgent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetDeliveryType(), other.isSetDeliveryType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeliveryType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deliveryType, other.deliveryType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Cargo(");
    boolean first = true;

    sb.append("products:");
    if (this.products == null) {
      sb.append("null");
    } else {
      sb.append(this.products);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("isUrgent:");
    sb.append(this.isUrgent);
    first = false;
    if (!first) sb.append(", ");
    sb.append("deliveryType:");
    if (this.deliveryType == null) {
      sb.append("null");
    } else {
      sb.append(this.deliveryType);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (products == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'products' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'isUrgent' because it's a primitive and you chose the non-beans generator.
    if (deliveryType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'deliveryType' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CargoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public CargoStandardScheme getScheme() {
      return new CargoStandardScheme();
    }
  }

  private static class CargoStandardScheme extends org.apache.thrift.scheme.StandardScheme<Cargo> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, Cargo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PRODUCTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.products = new java.util.ArrayList<Product>(_list0.size);
                @org.apache.thrift.annotation.Nullable Product _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new Product();
                  _elem1.read(iprot);
                  struct.products.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setProductsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // IS_URGENT
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isUrgent = iprot.readBool();
              struct.setIsUrgentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DELIVERY_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.deliveryType = com.github.DeliveryType.findByValue(iprot.readI32());
              struct.setDeliveryTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetIsUrgent()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'isUrgent' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, Cargo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.products != null) {
        oprot.writeFieldBegin(PRODUCTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.products.size()));
          for (Product _iter3 : struct.products)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(IS_URGENT_FIELD_DESC);
      oprot.writeBool(struct.isUrgent);
      oprot.writeFieldEnd();
      if (struct.deliveryType != null) {
        oprot.writeFieldBegin(DELIVERY_TYPE_FIELD_DESC);
        oprot.writeI32(struct.deliveryType.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CargoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public CargoTupleScheme getScheme() {
      return new CargoTupleScheme();
    }
  }

  private static class CargoTupleScheme extends org.apache.thrift.scheme.TupleScheme<Cargo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Cargo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.products.size());
        for (Product _iter4 : struct.products)
        {
          _iter4.write(oprot);
        }
      }
      oprot.writeBool(struct.isUrgent);
      oprot.writeI32(struct.deliveryType.getValue());
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Cargo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list5 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        struct.products = new java.util.ArrayList<Product>(_list5.size);
        @org.apache.thrift.annotation.Nullable Product _elem6;
        for (int _i7 = 0; _i7 < _list5.size; ++_i7)
        {
          _elem6 = new Product();
          _elem6.read(iprot);
          struct.products.add(_elem6);
        }
      }
      struct.setProductsIsSet(true);
      struct.isUrgent = iprot.readBool();
      struct.setIsUrgentIsSet(true);
      struct.deliveryType = com.github.DeliveryType.findByValue(iprot.readI32());
      struct.setDeliveryTypeIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

