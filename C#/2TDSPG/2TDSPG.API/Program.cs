
using Microsoft.OpenApi.Models;

namespace _2TDSPG.API
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container depemcy injection;

            ////Criado uma vez e usamos toda vez que precisamos
            //builder.Services.AddSingleton();

            ////Tenho pre definido e termino de criar quando precisar
            //builder.Services.AddScoped();
            
            ////Tenho pre definido e pre criado quando precisar
            //builder.Services.AddTransient();

            builder.Services.AddControllers();
            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen(x =>
            x.SwaggerDoc("v1", new OpenApiInfo
            {
                Title = "2TDSPG = EXEMPLOS DE NOMES",
                Description = "Exemplo de aula",
                Contact = new OpenApiContact() { Name = "Gustavo", Email= "gglazzuri@gmail.com"}


            })
            );

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseHttpsRedirection();

            app.UseAuthorization();


            app.MapControllers();

            app.Run();
        }
    }
}
