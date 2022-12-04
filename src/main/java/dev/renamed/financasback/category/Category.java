package dev.renamed.financasback.category;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "categories", indexes = @Index(name="idx_name", columnList = "name", unique = true))
public class Category
{
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
    name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = false)
  private Restriction restriction;

  @Column(nullable = false)
  private String name;

  private String description;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Restriction getRestriction() {
    return restriction;
  }

  public void setRestriction(Restriction restriction) {
    this.restriction = restriction;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category getParent() {
    return parent;
  }

  public void setParent(Category parent) {
    this.parent = parent;
  }

  public Collection<Category> getChildren() {
    return children;
  }

  public void setChildren(Collection<Category> children) {
    this.children = children;
  }

  @JoinColumn(nullable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  private Category parent;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
  private Collection<Category> children;

}