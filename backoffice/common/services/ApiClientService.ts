import whitelistedEndpoints from '@constants/WhitelistedEndpoints';

interface RequestOptions {
  method: string;
  headers: {
    'Content-type': string;
    [key: string]: string;
  };
  body?: string;
}

const sendRequest = async (method: string, endpoint: string, data: any = null) => {
  const url = new URL(endpoint, window.location.origin);
  if (!whitelistedEndpoints.includes(url.pathname)) {
    throw new Error(`Endpoint ${endpoint} is not whitelisted.`);
  }

  const requestOptions: RequestOptions = {
    method: method.toUpperCase(),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  };

  if (data) {
    requestOptions.body = data;
  }

  try {
    const response = await fetch(endpoint, method === 'GET' ? undefined : requestOptions);

    // Workaround to manually redirect in case of CORS error
    if (response.type == 'cors' && response.redirected == true) {
      window.location.href = response.url;
    }

    return response;
  } catch (error) {
    console.error('API call error:', error);
    throw error;
  }
};

const apiClientService = {
  get: (endpoint: string) => sendRequest('GET', endpoint),
  post: (endpoint: string, data: any) => sendRequest('POST', endpoint, data),
  put: (endpoint: string, data: any) => sendRequest('PUT', endpoint, data),
  delete: (endpoint: string) => sendRequest('DELETE', endpoint),
};

export default apiClientService;
