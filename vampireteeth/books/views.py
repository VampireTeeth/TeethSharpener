# Create your views here.

from django.shortcuts import render_to_response, get_object_or_404
from books.models import Book

def index(request):
  return render_to_response('books/index.html')

def search(request):
  if 'q' in request.GET and request.GET['q']:
    query = request.GET['q']
    books = Book.objects.filter(title__icontains=query)
    return render_to_response('books/search_result.html',
                               {'books':books,
                                'q':query})
  return render_to_response('books/index.html',
                             {'error_message':'Please input the searching text'})
    
def detail(request, book_id):
  book = get_object_or_404(Book, pk=book_id) 
  return render_to_response('books/book_detail.html',
                            {'book':book})
    