
using Microsoft.OpenApi.Models;

namespace TDSPG.API
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container depency injector.

            //// Criado uma vez e usamos toda vez que precisamos
            //builder.Services.AddSingleton();

            //// Tenho pre definido e termino de criar quando precisar
            //builder.Services.AddScoped();

            //// Tenho pre definido e pre criado  quando precisar termino
            //builder.Services.AddTransient();

            builder.Services.AddControllers();
            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen(x =>
            {
                x.SwaggerDoc("v1", new OpenApiInfo
                {
                    Title = builder.Configuration["Swagger:Title"],
                    Description = "Exemplos da aula de advanced .Net",
                    Contact = new OpenApiContact() { Name = "Prof Keller", Email = "profthiago@fiap.com.br"}
                });
            });

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
