# Create your views here.
from django.core.mail import send_mail
from django.core.urlresolvers import reverse
from django.http import HttpResponseRedirect
from django.shortcuts import render_to_response, get_object_or_404
from django.template import RequestContext
from books.models import Book


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



def fetch_contact_info(request):
  return (request.POST.get('subject', ''),
          request.POST.get('email', ''),
          request.POST.get('message', ''),
          )
  
def contact(request):
  if request.method == 'GET':
    return render_to_response(get_template('contact_form.html'), 
                              context_instance=RequestContext(request))
  
  if request.method == 'POST':
    errors = []
    subject, email, message = fetch_contact_info(request)
    
    if not subject:
      errors.append('Please enter the subject.')
    if not message:
      errors.append('Please enter the message.')
    if email and '@' not in email:
      errors.append('Please input a valid e-mail address.')
    if errors:
      return render_to_response(get_template('contact_form.html'),
                                {'errors':errors,
                                 'subject':subject,
                                 'email':email,
                                 'message':message,
                                 }, 
                                context_instance=RequestContext(request))
    
    recipient_list = ['steven.weike.liu@gmail.com']
    if not email:
      email = 'noreply@gmail.com'
#    send_mail(subject, message, email, recipient_list)
    return HttpResponseRedirect(reverse(thanks))
    
def thanks(request):
  return render_to_response(get_template('contact_thanks.html'))