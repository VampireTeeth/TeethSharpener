# Create your views here.
from django.core.mail import send_mail
from django.core.urlresolvers import reverse
from django.http import HttpResponseRedirect
from django.shortcuts import render_to_response, get_object_or_404
from django.template import RequestContext
from books.models import Book
from books.forms import ContactForm


def get_template(page):
  return 'books/%s' % page

def index(request):
  return render_to_response(get_template('index.html'))

def search(request):
  if 'q' in request.GET and request.GET['q']:
    query = request.GET['q']
    books = Book.objects.filter(title__icontains=query)
    return render_to_response(get_template('search_result.html'),
                               {'books':books,
                                'q':query})
  return render_to_response(get_template('index.html'),
                             {'error_message':'Please input the searching text'})
    
def detail(request, book_id):
  book = get_object_or_404(Book, pk=book_id) 
  return render_to_response(get_template('book_detail.html'),
                            {'book':book})

  
def contact(request):
  
  if request.method == 'POST':
    form = ContactForm(request.POST)
    if form.is_valid():
      cd = form.cleaned_data
#      send_mail(cd['subject'], cd['message'], cd.get('email', 'noreply@gmail.com'), ['steven.weike.liu@gmail.com'])
      return HttpResponseRedirect(reverse(thanks))
  else:
    form = ContactForm()
  return render_to_response(get_template('contact_form.html'),
                                {'form':form}, 
                                context_instance=RequestContext(request))
    
def thanks(request):
  return render_to_response(get_template('contact_thanks.html'))