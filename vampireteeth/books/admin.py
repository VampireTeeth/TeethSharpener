'''
Created on Sep 28, 2012

@author: steven
'''

from django.contrib import admin
from books.models import Publisher, Author, Book

class PublisherInline(admin.TabularInline):
  model = Publisher
  
class AuthorInline(admin.TabularInline):
  model = Author
  
class BookInline(admin.TabularInline):
  model = Book
  extra = 3

class PublisherAdmin(admin.ModelAdmin):
  list_display = ['name', 'address', 'city', 'state', 'country', 'website']
  inlines = [BookInline]

class AuthorAdmin(admin.ModelAdmin):
  pass

class BookAdmin(admin.ModelAdmin):
  list_display = ['title', 'pub_date']
  
admin.site.register(Publisher, PublisherAdmin)
admin.site.register(Book, BookAdmin)
admin.site.register(Author, AuthorAdmin)
  
