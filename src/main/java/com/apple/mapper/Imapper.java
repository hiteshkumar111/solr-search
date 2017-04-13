package com.apple.mapper;

public interface Imapper {
  <S, D> D map(S sourceObject, Class<D> destinationClass);
}
