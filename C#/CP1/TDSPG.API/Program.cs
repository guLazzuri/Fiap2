using Microsoft.EntityFrameworkCore;
using Microsoft.OpenApi.Models;
using TDSPG.API.Domain.Entity;
using TDSPG.API.Infrastructure.Context;
using TDSPG.API.Infrastructure.Persistence.Repositories;

namespace TDSPG.API
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container depency injector.

            ////Criado uma vez e usamos toda vez que precisamos
            //builder.Services.AddSingleton();

            ////Tenho pre definido e termino de criar quando precisar
            //builder.Services.AddScoped();

            ////Tenho pre definido e pre criado quando precisar termino
            //builder.Services.AddTransient();

            builder.Services.AddControllers();
            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen(x =>
            {
                x.SwaggerDoc("v1", new OpenApiInfo
                {
                    Title = builder.Configuration["Swagger:Title"],
                    Description = "Exemplos da aula de Advanced .Net",
                    Contact = new OpenApiContact() { Name = "Professor Thiago Keller", Email = "profthiago.vicco@fiap.com.br"}
                });
            });

            builder.Services.AddDbContext<TDSPGContext>(options =>
            {
                options.UseOracle(builder.Configuration.GetConnectionString("Oracle"));
            });

            builder.Services.AddScoped<IRepository<Establishment>, Repository<Establishment>>();


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