package magua.immutable

import scala.collection.mutable.StringBuilder
import scala.collection.immutable.Map

abstract class NTree[K, V] {
  def isEmpty = hasChildren || hasValue
  def hasChildren: Boolean
  def hasValue: Boolean
  def get(key: K): V
  def addOrReplace(t: NTree[K, V]): NTree[K, V]
  def forEach(f: (NTree[K, V]) => Unit): Unit
}
object EmptyTree extends NTree[Nothing, Nothing] {
  def hasChildren = false
  def hasValue = false
  def get(key: Nothing) = throw new NoSuchElementException(key)
  def addOrReplace(t: NTree[Nothing, Nothing]) = throw new NotImplementedError
  def forEach(f: (NTree[Nothing, Nothing]) => Unit) = Unit
}
class NonEmptyTree[K, V](children: NTree[K, V]) extends NTree {
  def hasChildren = false
  def hasValue = false
  def get(key: Nothing) = throw new NoSuchElementException(key)
  def addOrReplace(t: NTree[Nothing, Nothing]) = throw new NotImplementedError
  def forEach(f: (NTree[Nothing, Nothing]) => Unit) = Unit
}